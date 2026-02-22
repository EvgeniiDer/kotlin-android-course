package com.example.meetingapp
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    // Тег для поиска логов
    private val TAG = "LifecycleLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Экран создан")

        val btnDate = findViewById<Button>(R.id.btnDate);
        val tvDate = findViewById<TextView>(R.id.tvDate);
        val btnTime = findViewById<Button>(R.id.btnTime);
        val tvTime = findViewById<TextView>(R.id.tvTime);
        val btnConfirm = findViewById<Button>(R.id.btnConfirm);
        val btnShare = findViewById<Button>(R.id.btnShare);

        btnDate.setOnClickListener {
            val calendar = Calendar.getInstance();
            val year = calendar.get(Calendar.YEAR);
            val month = calendar.get(Calendar.MONTH);
            val day = calendar.get(Calendar.DAY_OF_MONTH);

            val dateDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                val realMonth = selectedMonth + 1
                tvDate.text = "$selectedDay.$realMonth.$selectedYear"
            }, year, month, day);
            dateDialog.show();
        }
        btnTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timeDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
               tvTime.text = String.format(("%02d:%02d"), selectedHour, selectedMinute)
            }, hour, minute, true);

            timeDialog.show();
        }
        btnConfirm.setOnClickListener {
            val date = tvDate.text.toString()
            val time = tvTime.text.toString()

            if(date =="Date not selected" || time == "Time not selected")
            {
                val toastWidget = Toast.makeText(this, "First select date and time!!", Toast.LENGTH_SHORT)
                toastWidget.show()
            }else
            {
                showConfirmationDialog(date, time);
            }
        }
        btnShare.setOnClickListener {
            val message = "Date selected on ${tvDate.text} in ${tvTime.text}"
            val sendIntenet = Intent().apply {
                action = Intent.ACTION_SEND // intent.setAction(...) аналог
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }
            startActivity((Intent.createChooser(sendIntenet, "Send via!!")))
        }
    }
    private fun showConfirmationDialog(date: String, time: String)
    {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmation")
        builder.setMessage("You selected date and time $date in $time. It's ok?")
        builder.setPositiveButton("Yea") {_, _ ->
            val toastWidget = Toast.makeText(this, "Done", Toast.LENGTH_SHORT);
            toastWidget.show();
        }
        builder.setNegativeButton("No", null);
        builder.show();

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Экран уничтожен")
    }
}