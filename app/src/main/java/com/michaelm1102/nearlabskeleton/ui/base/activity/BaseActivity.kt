package com.michaelm1102.nearlabskeleton.ui.base.activity

import android.app.AlertDialog
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId){

    private var progressDialog: AlertDialog? = null

    fun showProgressDialog(){
        if(progressDialog == null){
            //todo initialize dialog
        } else {
            progressDialog?.show()
        }
    }

    fun dismissProgressDialog(){
        progressDialog?.dismiss()
        progressDialog = null
    }
}