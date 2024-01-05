package com.nb.test

import android.os.Bundle
import android.webkit.WebResourceError
import android.widget.Button
import androidx.activity.ComponentActivity

import android.app.Activity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val webView = findViewById<WebView>(R.id.webView)


        webView.webViewClient = MyWebViewClient(this)
        webView.loadUrl("https://www.google.com/")
        webView.settings.javaScriptEnabled = true

        button1.setOnClickListener {
            webView.loadUrl("https://www.gmail.com/")
        }

        button2.setOnClickListener {
            webView.loadUrl("https://www.whatsapp.com/")
        }
    }

    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString()
            view?.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }
    }
}