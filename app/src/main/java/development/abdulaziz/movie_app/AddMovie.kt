package development.abdulaziz.movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import development.abdulaziz.movie_app.Cache.MySharedPreference
import development.abdulaziz.movie_app.Models.Cinema
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        MySharedPreference.init(this)
        btn_save.setOnClickListener {
            val arrayCinema = MySharedPreference.objectString
            val name = edt_movies_name.text.toString().trim()
            val author = edt_authors_movie.text.toString().trim()
            val description = edt_about_movies.text.toString().trim()
            val date = edt_movie_date.text.toString().trim()

            if (name != "" && author != "" && date != "" && description != "") {
                arrayCinema.add(Cinema(name, author, description, date))
                println(arrayCinema)
                MySharedPreference.objectString = arrayCinema
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Write Something", Toast.LENGTH_SHORT).show()
            }
        }
    }
}