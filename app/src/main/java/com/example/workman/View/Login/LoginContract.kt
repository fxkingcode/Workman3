package com.example.workman.View.Login


interface LoginContract {

    interface ILoginPresenter {
        fun onLogin(email: String, password: String)
    }


    interface ILoginView {
        fun onLoginSuccess(message: String)
        fun onLoginError(message: String)

    }
}
