package ht.koute.android.remote

import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import ht.koute.android.data.Show
import ht.koute.android.utils.Util
import kotlinx.coroutines.tasks.await

class AudioDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val newShowsCollectionPath =
        firestore.collection(Util.AppLevelConstants.NEW_SHOW_COLLECTION)

    suspend fun getAllNewShows(): List<Show> {
        return try {
            newShowsCollectionPath.get().await().toObjects(Show::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}