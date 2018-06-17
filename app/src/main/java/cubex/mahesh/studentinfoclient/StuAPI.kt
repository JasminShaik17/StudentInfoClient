package cubex.mahesh.studentinfoclient

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StuAPI {

    @GET("StudentsInfo/rs/stu/insert/{name}/{gender}/{qual}/{yop}")
    fun  insertStuInfo(
            @Path("name") name:String,
            @Path("gender") gender:String,
            @Path("qual") qual:String,
            @Path("yop") yop:String
            ):Call<StuPOJO>
}