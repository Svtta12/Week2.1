package science.example.week21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import science.example.week21.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    private val dataModel: DataModel by viewModels()
    private val TAG = "Second Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            openFragment(DescriptionFragment.newInstance(), R.id.plase_holder)
        }
        binding.button2.setOnClickListener {
            openFragment(Description2Fragment.newInstance(), R.id.plase_holder)
        }

        dataModel.message.observe(this) {
            binding.novoinaimi.text = it
        }

        dataModel.message2.observe(this) {
            binding.nokleimo.text = it
        }

        Log.i(TAG, "onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() called")
    }


    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}