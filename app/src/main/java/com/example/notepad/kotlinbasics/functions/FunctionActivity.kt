import com.example.notepad.R


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.kotlinbasics.functions.FunctionBasics

class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)
        FunctionBasics().main();
    }
}