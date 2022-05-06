package science.example.week21



import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import science.example.week21.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentDescriptionBinding
    private val TAG = "Fragment1"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(inflater)
            val dialog = AlertDialog.Builder(activity)
            dialog.setTitle("Автор")
                .setMessage("Лев Николаевич Толстой")
                .setPositiveButton("ОК") {
                        dialog, id -> dialog.cancel()
                }
            val alertDialog: AlertDialog? = dialog.create()
            alertDialog!!.setCancelable(false)
            alertDialog.show()

        Log.i(TAG, "onCreateView() called")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btntoactivity1.setOnClickListener {
            dataModel.message.value = "Прочитано"
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "onDetach() called")
    }

    companion object {
        @JvmStatic
        fun newInstance() = DescriptionFragment()
    }


}


