package com.example.planespotter

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.planespotter.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.add_plane.*
import kotlinx.android.synthetic.main.add_plane.view.*
import kotlinx.android.synthetic.main.latest_spots.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.util.*
import kotlin.collections.HashMap
import kotlin.system.exitProcess

//FOR MOBILE DEVELOPMENT BY FERDI VAN DEN BROM | 2079865

class PlanesActivity: AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    lateinit var filepath : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_plane)
        pickDate()

        //BUTTONS & CLICK LISTENERS START

        //button_upload.setEnabled(false)
        submit_planes_activity.setOnClickListener {

            if (//button_upload.isEnabled.equals(true) &&
                button_choose_image.isEnabled.equals(true) &&

                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5") &&

                insert_time.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().isNotEmpty() &&
                insert_plane_type.text.toString().isNotEmpty() &&
                insert_location_name.text.toString().isNotEmpty() &&
                insert_location_gpscode.text.toString().isNotEmpty() &&
                insert_destination_takeoff.text.toString().isNotEmpty() &&
                insert_destination_arrival.text.toString().isNotEmpty()) {

                val date = insert_time.text.toString()
                val planeType = insert_plane_type.text.toString()
                val locationName = insert_location_name.text.toString()
                val locationGPS = insert_location_gpscode.text.toString()
                val destinationTakeoff = insert_destination_takeoff.text.toString()
                val destinationArrival = insert_destination_arrival.text.toString()

                saveFireStore(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

                uploadFile()

            } else {

                Toast.makeText(this@PlanesActivity, "Please fill in the textboxes, date, time and choose a file to be able to submit", Toast.LENGTH_LONG).show()

            }

        }

        submit_planes_activity2.setOnClickListener {

            if (//button_upload.isEnabled.equals(false) &&
                button_choose_image.isEnabled.equals(true) &&

                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5") &&

                insert_time.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().isNotEmpty() &&
                insert_plane_type.text.toString().isNotEmpty() &&
                insert_location_name.text.toString().isNotEmpty() &&
                insert_location_gpscode.text.toString().isNotEmpty() &&
                insert_destination_takeoff.text.toString().isNotEmpty() &&
                insert_destination_arrival.text.toString().isNotEmpty()) {

                val date2 = insert_time.text.toString()
                val planeType2 = insert_plane_type.text.toString()
                val locationName2 = insert_location_name.text.toString()
                val locationGPS2 = insert_location_gpscode.text.toString()
                val destinationTakeoff2 = insert_destination_takeoff.text.toString()
                val destinationArrival2 = insert_destination_arrival.text.toString()

                saveFireStore2(date2, planeType2, locationName2, locationGPS2, destinationArrival2, destinationTakeoff2)

                uploadFile()

            } else {

                Toast.makeText(this@PlanesActivity, "Please fill in the textboxes, date, time and choose a file to be able to submit", Toast.LENGTH_LONG).show()

            }

        }

        submit_planes_activity3.setOnClickListener {

            if (//button_upload.isEnabled.equals(false) &&
                button_choose_image.isEnabled.equals(true) &&

                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5") &&

                insert_time.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().isNotEmpty() &&
                insert_plane_type.text.toString().isNotEmpty() &&
                insert_location_name.text.toString().isNotEmpty() &&
                insert_location_gpscode.text.toString().isNotEmpty() &&
                insert_destination_takeoff.text.toString().isNotEmpty() &&
                insert_destination_arrival.text.toString().isNotEmpty()) {

                val date3 = insert_time.text.toString()
                val planeType3 = insert_plane_type.text.toString()
                val locationName3 = insert_location_name.text.toString()
                val locationGPS3 = insert_location_gpscode.text.toString()
                val destinationTakeoff3 = insert_destination_takeoff.text.toString()
                val destinationArrival3 = insert_destination_arrival.text.toString()

                saveFireStore3(date3, planeType3, locationName3, locationGPS3, destinationArrival3, destinationTakeoff3)

                uploadFile()

            } else {

                Toast.makeText(this@PlanesActivity, "Please fill in the textboxes, date, time and choose a file to be able to submit", Toast.LENGTH_LONG).show()

            }

        }

        submit_planes_activity4.setOnClickListener {

            if (//button_upload.isEnabled.equals(false) &&
                button_choose_image.isEnabled.equals(true) &&

                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5") &&

                insert_time.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().isNotEmpty() &&
                insert_plane_type.text.toString().isNotEmpty() &&
                insert_location_name.text.toString().isNotEmpty() &&
                insert_location_gpscode.text.toString().isNotEmpty() &&
                insert_destination_takeoff.text.toString().isNotEmpty() &&
                insert_destination_arrival.text.toString().isNotEmpty()) {

                val date4 = insert_time.text.toString()
                val planeType4 = insert_plane_type.text.toString()
                val locationName4 = insert_location_name.text.toString()
                val locationGPS4 = insert_location_gpscode.text.toString()
                val destinationTakeoff4 = insert_destination_takeoff.text.toString()
                val destinationArrival4 = insert_destination_arrival.text.toString()

                saveFireStore4(date4, planeType4, locationName4, locationGPS4, destinationArrival4, destinationTakeoff4)

                uploadFile()

            } else {

                Toast.makeText(this@PlanesActivity, "Please fill in the textboxes, date, time and choose a file to be able to submit", Toast.LENGTH_LONG).show()

            }

        }

        submit_planes_activity5.setOnClickListener {

            if (//button_upload.isEnabled.equals(false) &&
                button_choose_image.isEnabled.equals(true) &&

                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5") &&

                insert_time.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().isNotEmpty() &&
                insert_plane_type.text.toString().isNotEmpty() &&
                insert_location_name.text.toString().isNotEmpty() &&
                insert_location_gpscode.text.toString().isNotEmpty() &&
                insert_destination_takeoff.text.toString().isNotEmpty() &&
                insert_destination_arrival.text.toString().isNotEmpty()) {

                val date5 = insert_time.text.toString()
                val planeType5 = insert_plane_type.text.toString()
                val locationName5 = insert_location_name.text.toString()
                val locationGPS5 = insert_location_gpscode.text.toString()
                val destinationTakeoff5 = insert_destination_takeoff.text.toString()
                val destinationArrival5 = insert_destination_arrival.text.toString()

                saveFireStore5(date5, planeType5, locationName5, locationGPS5, destinationArrival5, destinationTakeoff5)

                uploadFile()

            } else {

                Toast.makeText(this@PlanesActivity, "Please fill in the textboxes, date, time and choose a file to be able to submit", Toast.LENGTH_LONG).show()

            }

        }

        button_choose_image.setOnClickListener {

            startFileChooser()

        }

        /*button_upload.setOnClickListener {

            if (insert_file_name.text.toString().isNotEmpty() &&
                insert_file_name.text.toString().equals("1") ||
                insert_file_name.text.toString().equals("2") ||
                insert_file_name.text.toString().equals("3") ||
                insert_file_name.text.toString().equals("4") ||
                insert_file_name.text.toString().equals("5")
            ) {
                uploadFile()
                button_upload.setEnabled(false)
                button_choose_image.setEnabled(false)

            } else {

                Toast.makeText(this@PlanesActivity, "Enter a spot number (1-5) to be able to upload your file", Toast.LENGTH_LONG).show()

            }
        }*/

        //BUTTONS & CLICK LISTENERS END.

    }

    //SEND DATA TO CLOUD FIRE STORE START

    private fun saveFireStore(date: String, planeType: String, locationName: String,
                              locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival

        db.collection("spots").document("firstSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@PlanesActivity, "Added succesfully to spot I.", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this@PlanesActivity, "Added unsuccesfully to spot I.", Toast.LENGTH_LONG).show()
            }

    }

    private fun saveFireStore2(date2: String, planeType2: String, locationName2: String,
                              locationGPS2: String, destinationTakeoff2: String, destinationArrival2: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date2
        user["planeType"] = planeType2
        user["locationName"] = locationName2
        user["locationGPS"] = locationGPS2
        user["destinationTakeoff"] = destinationTakeoff2
        user["destinationArrival"] = destinationArrival2

        db.collection("spots").document("secondSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@PlanesActivity, "Added succesfully to spot II.", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this@PlanesActivity, "Added unsuccesfully to spot II.", Toast.LENGTH_LONG).show()
            }

    }

    private fun saveFireStore3(date3: String, planeType3: String, locationName3: String,
                               locationGPS3: String, destinationTakeoff3: String, destinationArrival3: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date3
        user["planeType"] = planeType3
        user["locationName"] = locationName3
        user["locationGPS"] = locationGPS3
        user["destinationTakeoff"] = destinationTakeoff3
        user["destinationArrival"] = destinationArrival3

        db.collection("spots").document("thirdSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@PlanesActivity, "Added succesfully to spot III.", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this@PlanesActivity, "Added unsuccesfully to spot III.", Toast.LENGTH_LONG).show()
            }

    }

    private fun saveFireStore4(date4: String, planeType4: String, locationName4: String,
                               locationGPS4: String, destinationTakeoff4: String, destinationArrival4: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date4
        user["planeType"] = planeType4
        user["locationName"] = locationName4
        user["locationGPS"] = locationGPS4
        user["destinationTakeoff"] = destinationTakeoff4
        user["destinationArrival"] = destinationArrival4

        db.collection("spots").document("fourthSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@PlanesActivity, "Added succesfully to spot IV.", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this@PlanesActivity, "Added unsuccesfully to spot IV.", Toast.LENGTH_LONG).show()
            }

    }

    private fun saveFireStore5(date5: String, planeType5: String, locationName5: String,
                               locationGPS5: String, destinationTakeoff5: String, destinationArrival5: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date5
        user["planeType"] = planeType5
        user["locationName"] = locationName5
        user["locationGPS"] = locationGPS5
        user["destinationTakeoff"] = destinationTakeoff5
        user["destinationArrival"] = destinationArrival5

        db.collection("spots").document("fifthSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@PlanesActivity, "Added succesfully to spot V.", Toast.LENGTH_LONG).show()

            }
            .addOnFailureListener {
                Toast.makeText(this@PlanesActivity, "Added unsuccesfully to spot V.", Toast.LENGTH_LONG).show()
            }

    }

    //SEND DATA TO CLOUD FIRE STORE END

    //UPLOAD IMAGE FILE TO STORAGE START

    private fun uploadFile() {
        if (filepath!=null) {
            var pd = ProgressDialog(this)
            pd.setTitle("Uploading")
            pd.show()

            var getfilename: String = insert_file_name.text.toString()

            var imageRef = FirebaseStorage.getInstance().reference.child("images/spot$getfilename")
            imageRef.putFile(filepath)
                    .addOnSuccessListener {p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext,"File Uploaded",Toast.LENGTH_SHORT).show()

                        moveTaskToBack(true)
                        exitProcess(-1)
                    }
                    .addOnFailureListener {p0 ->
                        pd.dismiss()
                        Toast.makeText(applicationContext,p0.message,Toast.LENGTH_SHORT).show()
                    }
                    .addOnProgressListener {p0 ->
                        var progress = (100.0 * p0.bytesTransferred) / p0.totalByteCount
                        pd.setMessage("Uploaded ${progress.toInt()}%")
                    }
        }
    }

    private fun startFileChooser() {
        var i = Intent()
        i.setType("image/*")
        i.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(i, "Choose Picture"),111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==111 && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.data!!
            var bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filepath)
            image_view.setImageBitmap(bitmap)
            //button_upload.setEnabled(true)
        }
    }

    //UPLOAD IMAGE FILE TO STORAGE END

    //CALENDER & DATE PICKER START

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    private fun getDateTimeCalender() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        month = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        button_timepicker.setOnClickListener {
            getDateTimeCalender()

            DatePickerDialog(this,this,year,month,day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalender()

        TimePickerDialog(this,this,hour,minute,true).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        insert_time.text = " $savedDay-$savedMonth-$savedYear | $savedHour:$savedMinute"
    }

    //CALENDER & DATE PICKER END

}

