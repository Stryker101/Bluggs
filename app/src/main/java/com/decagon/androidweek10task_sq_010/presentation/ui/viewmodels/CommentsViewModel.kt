package com.decagon.androidweek10task_sq_010.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decagon.androidweek10task_sq_010.data.repository.Repository
import com.decagon.androidweek10task_sq_010.presentation.models.Comments
import com.example.week9task.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val comments: MutableLiveData<Resource<List<Comments>>> = MutableLiveData()

    private fun getComments(postId: Int) = viewModelScope.launch {
        comments.postValue(Resource.Loading())
        val response = repository.getComments(postId)
        viewModelScope.launch {
            comments.postValue(handleComments(response))
        }
    }

    fun loadComments(postId: Int) = viewModelScope.launch {
        if (repository.loadComments(postId).isEmpty()) {
            getComments(postId)
        } else {
            val load = repository.loadComments(postId)
            comments.postValue(Resource.Success(load))
        }
    }

    fun addComments(postId: Int, comments: Comments) {
        viewModelScope.launch {
            val response = repository.addComment(postId, comments)
            if (response.isSuccessful) {
                repository.addCommentToDatabase(response.body()!!)
                loadComments(postId)
            }
        }
    }

    private suspend fun handleComments(response: Response<List<Comments>>): Resource<List<Comments>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(
                    repository.saveCommentsToDb(resultResponse)
                )
            }
        }
        return Resource.Error(response.message())
    }
}
