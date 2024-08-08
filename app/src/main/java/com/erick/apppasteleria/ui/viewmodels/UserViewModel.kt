package com.erick.apppasteleria.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.apppasteleria.data.database.User
import com.erick.apppasteleria.data.database.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val userDao: UserDao) : ViewModel() {

    fun register(username: String, password: String) = viewModelScope.launch {
        viewModelScope.launch (Dispatchers.IO) {
            val user = User(username = username, password = password)
            userDao.insert(user)
        }
    }

    suspend fun login(username: String, password: String): User? {
        return withContext(Dispatchers.IO){
            userDao.getUser(username, password)
        }

        }
    }

