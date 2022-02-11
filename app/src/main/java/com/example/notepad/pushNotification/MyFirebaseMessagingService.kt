package com.example.notepad.pushNotification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.notepad.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage

const val channelId="notification_channel"
const val channelName="com.example.notepad.pushNotification"
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.notification !=null){
            remoteMessage.notification!!.title?.let { remoteMessage.notification!!.body?.let { it1 ->
                generateNotification(it, it1)
            } }
            }
    }
    //generate the notification
    //attach the notification created with the custom layout
    //show notification


    fun generateNotification(title:String,message:String)
    {
        val intent= Intent(this,NotificationActivity::class.java)
        //clear all the activity in the stack and make this activity as top
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //we have intent that we want to use the intent in future
        //one shot use this activity only once
        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

        //channel id,channel name
        var builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext,
            channelId).setSmallIcon(R.drawable.ic_sun)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder=builder.setContent(getRemoteView(title,message))
        val notificationManager =getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
        {
            val notificationChannel=NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(0,builder.build())
        }
    }

    @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, message: String): RemoteViews? {
        val remoteViews=RemoteViews("com.example.notepad.pushNotification",R.layout.notification)
       remoteViews.setTextViewText(R.id.title,title)
        remoteViews.setTextViewText(R.id.desc,message)
        remoteViews.setImageViewResource(R.id.app_logo,R.drawable.ic_sun)
        return remoteViews
    }

}