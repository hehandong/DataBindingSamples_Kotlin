package github.leavesc.databinding

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import github.leavesc.databinding.databinding.ActivityMain15Binding
import github.leavesc.databinding.databinding.ActivityMain6Binding
import kotlinx.android.synthetic.main.activity_main15.*

class MainActivity15 : AppCompatActivity() {
    private val model: NameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMain15Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main15)

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            binding.tvFirstname.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        model.currentName.observe(this, nameObserver)
        model.currentName.observe(this,{
            binding.tvFirstname.text = it
        })
        binding.handlers = MyHandlers(model)

    }

    class MyHandlers(private val model: NameViewModel) {
        fun onClickFriend(view: View?) {
            val anotherName = "John Doe"
            model.currentName.value = anotherName
        }
    }
}