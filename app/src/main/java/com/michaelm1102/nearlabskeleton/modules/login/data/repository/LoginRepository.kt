package com.michaelm1102.nearlabskeleton.modules.login.data.repository

import com.michaelm1102.nearlabskeleton.modules.login.data.data_source.LoginApi
import com.michaelm1102.nearlabskeleton.modules.login.data.data_source.LoginDao

class LoginRepository(private val loginService: LoginApi, private val loginDao: LoginDao) {
}