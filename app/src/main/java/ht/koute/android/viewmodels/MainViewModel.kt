package ht.koute.android.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ht.koute.android.data.Show
import ht.koute.android.data.Suggestions
import ht.koute.android.remote.AudioDatabase
import ht.koute.android.utils.Util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private var _suggestionsList = MutableLiveData<List<Suggestions>>()
    var suggestionsList: LiveData<List<Suggestions>> = _suggestionsList

    private val _sermonsList = MutableLiveData<List<Show>>()
    val sermonsList: LiveData<List<Show>> = _sermonsList

    private val _newShowsList = MutableLiveData<List<Show>>()
    val newShowsList: LiveData<List<Show>> = _newShowsList

    private val _recommendedShowsList = MutableLiveData<List<Show>>()
    val recommendedShowsList: LiveData<List<Show>> = _recommendedShowsList

    private val _faithShowsList = MutableLiveData<List<Show>>()
    val faithShowsList: LiveData<List<Show>> = _faithShowsList

    fun setSuggestionsList(context: Context) {
        _suggestionsList.postValue(Util.createSuggestionsDataSet(context))
    }

    fun setSermonsList() {
        viewModelScope.launch {
            _sermonsList.postValue(AudioDatabase().getAllNewShows())
        }
    }

    fun setNewShowsList() {
        viewModelScope.launch {
            _newShowsList.postValue(AudioDatabase().getAllNewShows())
        }
    }

    fun setRecommendedShowsList() {
        viewModelScope.launch {
            _recommendedShowsList.postValue(AudioDatabase().getAllNewShows())
        }
    }

    fun setFaithShowsList() {
        viewModelScope.launch {
            _faithShowsList.postValue(AudioDatabase().getAllNewShows())
        }
    }
}