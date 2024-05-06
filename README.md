package com.example.imada2st10452399

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.imada2st10452399.R

class MainActivity2 : AppCompatActivity() {

    private var txthungry = 30
    private var txtclean = 30
    private var txthealth = 30

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        
        val txthungryTextView = findViewById<TextView>(R.id.txthungry)
        val txtcleanTextView = findViewById<TextView>(R.id.txtclean)
        val txthealthTextView = findViewById<TextView>(R.id.txthealth)


        // Retrieve the message passed from the welcome screen
        val feedMessage = intent.getStringExtra("FEED_ME")
        // Setting text to the feed TextView to feed message
        feedMessage?.let {
            txthungryTextView.text = it
            val cleanMessage = intent.getStringExtra("CLEAN ME")
            cleanMessage?.let { it ->
                txtcleanTextView.text = it
            }
            val playTime = intent.getStringExtra("I want to play")
            playTime.let { it ->
                txthealthTextView.text = it
            }
        }

        val feed = findViewById<Button>(R.id.btnfeed)
        val btnreturnToWelcomePage = findViewById<Button>(R.id.btnreturnToWelcomePage)
        val btnclean = findViewById<Button>(R.id.btnclean)

        btnclean.setOnClickListener {
            txtclean += 15
            if (txtclean > 100) txtclean = 100
            val intent = Intent(this@MainActivity2, bathingactivity1::class.java)
            startActivity(intent)
        }

        btnreturnToWelcomePage.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }

        val btnhappy = findViewById<Button>(R.id.btnhappy)
        btnhappy.setOnClickListener {
            txthealth += 20
            if (txthealth > 100)
                txthealth = 100
            val intent = Intent(this@MainActivity2, playActivity::class.java)
            startActivity(intent)
        }
        
        val btnfeed = findViewById<Button>(R.id.btnfeed)
        btnfeed.setOnClickListener {
            txthungry += 10
            if(txthungry > 100)
                txthungry = 100
            val intent = Intent(this@MainActivity2, EatingActivity::class.java)
            startActivity(intent)
        }

    }

    private fun updateStatusBar(statusBar: TextView) {
        val avg = (txthungry + txtclean + txthealth) / 3
        statusBar.text = "Health: $txthealth%\nHunger: $txthungry%\nClean: $txtclean%\nAverage: $avg%"
    }
}


MainActivity2(this is the home page) this is where you see your pet and where the pet tells you its needs . It facilitates communication with the welcome screen to initialize the pet's attributes and provides functionality to navigate to various activities within the application. They are 4 buttons on the home screen which are the feed me button where you click on the button in order to feed STEVE, A  clean button which takes you to a screen where STEVE is cleaning up him/herself, a Happy button which takes you to a screen where you will see STEVE playing. On all  4 of the pages there is a return button the 3 pages return button takes the user back to the home page and the return button on the  home page that goes back to the welcome page.
Essential variables to monitor the virtual pet's hygiene, health, and hunger are included in MainActivity2.kt. By using button click listeners, these variables can be changed, causing related actions like eating, cleaning, and playing to occur. The activity's layout is initialised by the onCreate() method, which also receives messages supplied from the welcome screen and updates the user interface accordingly. Furthermore, the average attribute level is computed by the updateStatusBar() method and shown on the status bar TextView.
