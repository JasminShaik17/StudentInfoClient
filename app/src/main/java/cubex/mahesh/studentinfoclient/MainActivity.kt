package cubex.mahesh.studentinfoclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var et1:EditText? = null
    var et2:EditText? = null
    var et3:EditText? = null
    var et4:EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        et3 = findViewById(R.id.et3)
        et4 = findViewById(R.id.et4)

    }


    fun insert(v:View)
    {
        var r = Retrofit.Builder().
    addConverterFactory(GsonConverterFactory.create()).
                baseUrl("http://10.0.0.2:8080/").build()
    var api = r.create(StuAPI::class.java)
   var call = api?.insertStuInfo(et1?.text.toString(),
           et2?.text.toString(),et3?.text.toString(),
           et4?.text.toString())
        call?.enqueue(object: Callback<StuPOJO> {
            override fun onFailure(call: Call<StuPOJO>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,
                        "Exception Raised...",
                        Toast.LENGTH_LONG).show()   }

            override fun onResponse(call: Call<StuPOJO>?, response: Response<StuPOJO>?) {

                Toast.makeText(this@MainActivity,
                        response?.body()?.status,
                        Toast.LENGTH_LONG).show()

            }

        })

    }
}
