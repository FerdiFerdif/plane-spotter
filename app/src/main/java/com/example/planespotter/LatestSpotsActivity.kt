package com.example.planespotter

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.latest_spots.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.Exception
import kotlin.system.exitProcess

//FOR MOBILE DEVELOPMENT BY FERDI VAN DEN BROM | 2079865

class LatestSpotsActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.latest_spots)

        //VARIABLES START

        val db = FirebaseFirestore.getInstance()

        val image_url1 = "https://firebasestorage.googleapis.com/v0/b/plane-spotter-dacd4.appspot.com/o/images%2Fspot1?alt=media&token=fe70c58b-3b23-4791-b83d-f01bbc7bf2dc"
        val image_url2 = "https://firebasestorage.googleapis.com/v0/b/plane-spotter-dacd4.appspot.com/o/images%2Fspot2?alt=media&token=e6b33845-3acd-42cb-bc61-d19367043f09"
        val image_url3 = "https://firebasestorage.googleapis.com/v0/b/plane-spotter-dacd4.appspot.com/o/images%2Fspot3?alt=media&token=0c5a21c7-5dd4-41cc-8d6a-1b525f2ff3c1"
        val image_url4 = "https://firebasestorage.googleapis.com/v0/b/plane-spotter-dacd4.appspot.com/o/images%2Fspot4?alt=media&token=0922138b-3862-4225-9ea9-cb78c007afe1"
        val image_url5 = "https://firebasestorage.googleapis.com/v0/b/plane-spotter-dacd4.appspot.com/o/images%2Fspot5?alt=media&token=aba6c070-9dfa-43a8-82d8-2a1889a7ea43"

        val date = findViewById(R.id.results_date1) as TextView
        val planeType = findViewById(R.id.results_planeType1) as TextView
        val locationName = findViewById(R.id.results_locationName1) as TextView
        val locationGPS = findViewById(R.id.results_locationGPS1) as TextView
        val destinationTakeoff = findViewById(R.id.results_destinationTakeoff1) as TextView
        val destinationArrival = findViewById(R.id.results_destinationArrival1) as TextView

        val date2 = findViewById(R.id.results_date2) as TextView
        val planeType2 = findViewById(R.id.results_planeType2) as TextView
        val locationName2 = findViewById(R.id.results_locationName2) as TextView
        val locationGPS2 = findViewById(R.id.results_locationGPS2) as TextView
        val destinationTakeoff2 = findViewById(R.id.results_destinationTakeoff2) as TextView
        val destinationArrival2 = findViewById(R.id.results_destinationArrival2) as TextView

        val date3 = findViewById(R.id.results_date3) as TextView
        val planeType3 = findViewById(R.id.results_planeType3) as TextView
        val locationName3 = findViewById(R.id.results_locationName3) as TextView
        val locationGPS3 = findViewById(R.id.results_locationGPS3) as TextView
        val destinationTakeoff3 = findViewById(R.id.results_destinationTakeoff3) as TextView
        val destinationArrival3 = findViewById(R.id.results_destinationArrival3) as TextView

        val date4 = findViewById(R.id.results_date4) as TextView
        val planeType4 = findViewById(R.id.results_planeType4) as TextView
        val locationName4 = findViewById(R.id.results_locationName4) as TextView
        val locationGPS4 = findViewById(R.id.results_locationGPS4) as TextView
        val destinationTakeoff4 = findViewById(R.id.results_destinationTakeoff4) as TextView
        val destinationArrival4 = findViewById(R.id.results_destinationArrival4) as TextView

        val date5 = findViewById(R.id.results_date5) as TextView
        val planeType5 = findViewById(R.id.results_planeType5) as TextView
        val locationName5 = findViewById(R.id.results_locationName5) as TextView
        val locationGPS5 = findViewById(R.id.results_locationGPS5) as TextView
        val destinationTakeoff5 = findViewById(R.id.results_destinationTakeoff5) as TextView
        val destinationArrival5 = findViewById(R.id.results_destinationArrival5) as TextView

        //VARIABLES END

        //BUTTONS & CLICK LISTENERS START

        clear_spot.setOnClickListener {

            if (results_date1.text.isNotEmpty() ||
                FirebaseStorage.getInstance().reference.child("images/spot1").equals(FirebaseStorage.getInstance().reference.child("images/spot1"))) {

                val date = empty.text.toString()
                val planeType = empty.text.toString()
                val locationName = empty.text.toString()
                val locationGPS = empty.text.toString()
                val destinationTakeoff = empty.text.toString()
                val destinationArrival = empty.text.toString()

                var imageRef = FirebaseStorage.getInstance().reference.child("images/spot1")
                imageRef.delete()

                emptyFireStore(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

            } else {

                Toast.makeText(this@LatestSpotsActivity, "Your spot already contains no data", Toast.LENGTH_LONG).show()

            }

        }

        clear_spot2.setOnClickListener {

            if (results_date2.text.isNotEmpty() ||
                FirebaseStorage.getInstance().reference.child("images/spot2").equals(FirebaseStorage.getInstance().reference.child("images/spot2"))) {

                val date = empty.text.toString()
                val planeType = empty.text.toString()
                val locationName = empty.text.toString()
                val locationGPS = empty.text.toString()
                val destinationTakeoff = empty.text.toString()
                val destinationArrival = empty.text.toString()

                var imageRef = FirebaseStorage.getInstance().reference.child("images/spot2")
                imageRef.delete()

                emptyFireStore2(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

            } else {

                Toast.makeText(this@LatestSpotsActivity, "Your spot already contains no data", Toast.LENGTH_LONG).show()

            }

        }

        clear_spot3.setOnClickListener {

            if (results_date3.text.isNotEmpty() ||
                FirebaseStorage.getInstance().reference.child("images/spot3").equals(FirebaseStorage.getInstance().reference.child("images/spot3"))) {

                val date = empty.text.toString()
                val planeType = empty.text.toString()
                val locationName = empty.text.toString()
                val locationGPS = empty.text.toString()
                val destinationTakeoff = empty.text.toString()
                val destinationArrival = empty.text.toString()

                var imageRef = FirebaseStorage.getInstance().reference.child("images/spot3")
                imageRef.delete()

                emptyFireStore3(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

            } else {

                Toast.makeText(this@LatestSpotsActivity, "Your spot already contains no data", Toast.LENGTH_LONG).show()

            }

        }

        clear_spot4.setOnClickListener {

            if (results_date4.text.isNotEmpty() ||
                FirebaseStorage.getInstance().reference.child("images/spot4").equals(FirebaseStorage.getInstance().reference.child("images/spot4"))) {

                val date = empty.text.toString()
                val planeType = empty.text.toString()
                val locationName = empty.text.toString()
                val locationGPS = empty.text.toString()
                val destinationTakeoff = empty.text.toString()
                val destinationArrival = empty.text.toString()

                var imageRef = FirebaseStorage.getInstance().reference.child("images/spot4")
                imageRef.delete()

                emptyFireStore4(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

            } else {

                Toast.makeText(this@LatestSpotsActivity, "Your spot already contains no data", Toast.LENGTH_LONG).show()

            }

        }

        clear_spot5.setOnClickListener {

            if (results_date5.text.isNotEmpty() ||
                FirebaseStorage.getInstance().reference.child("images/spot5").equals(FirebaseStorage.getInstance().reference.child("images/spot5"))) {

                val date = empty.text.toString()
                val planeType = empty.text.toString()
                val locationName = empty.text.toString()
                val locationGPS = empty.text.toString()
                val destinationTakeoff = empty.text.toString()
                val destinationArrival = empty.text.toString()

                var imageRef = FirebaseStorage.getInstance().reference.child("images/spot5")
                imageRef.delete()

                emptyFireStore5(date, planeType, locationName, locationGPS, destinationArrival, destinationTakeoff)

            } else {

                Toast.makeText(this@LatestSpotsActivity, "Your spot already contains no data", Toast.LENGTH_LONG).show()

            }

        }

        //BUTTONS & CLICK LISTENERS END

        //SEND DATA TO CLOUD FIRE STORE & STORAGE START

        val docRef = db.collection("spots").document("firstSpot")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")

                    date.text = document.getString("date")
                    planeType.text = document.getString("planeType")
                    locationName.text = document.getString("locationName")
                    locationGPS.text = document.getString("locationGPS")
                    destinationArrival.text = document.getString("destinationArrival")
                    destinationTakeoff.text = document.getString("destinationTakeoff")
                    Picasso.get().load(image_url1).into(image_view_spot1)

                } else {
                    Log.d("no exist", "First spot doesn't exist ")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error db", "get failed with ", exception)
            }

        val docRef2 = db.collection("spots").document("secondSpot")
        docRef2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")

                    date2.text = document.getString("date")
                    planeType2.text = document.getString("planeType")
                    locationName2.text = document.getString("locationName")
                    locationGPS2.text = document.getString("locationGPS")
                    destinationArrival2.text = document.getString("destinationArrival")
                    destinationTakeoff2.text = document.getString("destinationTakeoff")
                    Picasso.get().load(image_url2).into(image_view_spot2)

                } else {
                    Log.d("no exist", "Second spot doesn't exist ")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error db", "get failed with ", exception)
            }

        val docRef3 = db.collection("spots").document("thirdSpot")
        docRef3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")

                    date3.text = document.getString("date")
                    planeType3.text = document.getString("planeType")
                    locationName3.text = document.getString("locationName")
                    locationGPS3.text = document.getString("locationGPS")
                    destinationArrival3.text = document.getString("destinationArrival")
                    destinationTakeoff3.text = document.getString("destinationTakeoff")
                    Picasso.get().load(image_url3).into(image_view_spot3)

                } else {
                    Log.d("no exist", "Third spot doesn't exist ")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error db", "get failed with ", exception)
            }

        val docRef4 = db.collection("spots").document("fourthSpot")
        docRef4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")

                    date4.text = document.getString("date")
                    planeType4.text = document.getString("planeType")
                    locationName4.text = document.getString("locationName")
                    locationGPS4.text = document.getString("locationGPS")
                    destinationArrival4.text = document.getString("destinationArrival")
                    destinationTakeoff4.text = document.getString("destinationTakeoff")
                    Picasso.get().load(image_url4).into(image_view_spot4)

                } else {
                    Log.d("no exist", "Fourth spot doesn't exist ")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error db", "get failed with ", exception)
            }

        val docRef5 = db.collection("spots").document("fifthSpot")
        docRef5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")

                    date5.text = document.getString("date")
                    planeType5.text = document.getString("planeType")
                    locationName5.text = document.getString("locationName")
                    locationGPS5.text = document.getString("locationGPS")
                    destinationArrival5.text = document.getString("destinationArrival")
                    destinationTakeoff5.text = document.getString("destinationTakeoff")
                    Picasso.get().load(image_url5).into(image_view_spot5)

                } else {
                    Log.d("no exist", "Fifth spot doesn't exist ")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("error db", "get failed with ", exception)
            }

    }

    private fun emptyFireStore(date: String, planeType: String, locationName: String,
                              locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival
        FirebaseStorage.getInstance()

        db.collection("spots").document("firstSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot I. succesfully ", Toast.LENGTH_LONG).show()

                moveTaskToBack(true)
                exitProcess(-1)
            }
            .addOnFailureListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot I. unsuccesfully ", Toast.LENGTH_LONG).show()
            }

    }

    private fun emptyFireStore2(date: String, planeType: String, locationName: String,
                               locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival
        FirebaseStorage.getInstance()

        db.collection("spots").document("secondSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot II. succesfully ", Toast.LENGTH_LONG).show()

                moveTaskToBack(true)
                exitProcess(-1)
            }
            .addOnFailureListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot II. unsuccesfully ", Toast.LENGTH_LONG).show()
            }

    }

    private fun emptyFireStore3(date: String, planeType: String, locationName: String,
                                locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival
        FirebaseStorage.getInstance()

        db.collection("spots").document("thirdSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot III. succesfully ", Toast.LENGTH_LONG).show()

                moveTaskToBack(true)
                exitProcess(-1)
            }
            .addOnFailureListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot III. unsuccesfully ", Toast.LENGTH_LONG).show()
            }

    }

    private fun emptyFireStore4(date: String, planeType: String, locationName: String,
                                locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival
        FirebaseStorage.getInstance()

        db.collection("spots").document("fourthSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot IV. succesfully ", Toast.LENGTH_LONG).show()

                moveTaskToBack(true)
                exitProcess(-1)
            }
            .addOnFailureListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot IV. unsuccesfully ", Toast.LENGTH_LONG).show()
            }

    }

    private fun emptyFireStore5(date: String, planeType: String, locationName: String,
                                locationGPS: String, destinationTakeoff: String, destinationArrival: String) {

        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()
        user["date"] = date
        user["planeType"] = planeType
        user["locationName"] = locationName
        user["locationGPS"] = locationGPS
        user["destinationTakeoff"] = destinationTakeoff
        user["destinationArrival"] = destinationArrival
        FirebaseStorage.getInstance()

        db.collection("spots").document("fifthSpot")
            .set(user)
            .addOnSuccessListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot V. succesfully ", Toast.LENGTH_LONG).show()

                moveTaskToBack(true)
                exitProcess(-1)
            }
            .addOnFailureListener {
                Toast.makeText(this@LatestSpotsActivity, "Cleared spot V. unsuccesfully ", Toast.LENGTH_LONG).show()
            }

    }

    //SEND DATA TO CLOUD FIRE STORE & STORAGE END

}

