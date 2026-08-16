package com.horoscope.mini.billing

import android.content.Context
import com.android.billingclient.api.BillingClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BillingManager @Inject constructor(context: Context) {
    private val billingClient = BillingClient.newBuilder(context)
        .setListener { _, _ -> }
        .enablePendingPurchases()
        .build()

    fun startConnection() {
        billingClient.startConnection(object : BillingClient.BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: com.android.billingclient.api.BillingResult) {}
            override fun onBillingServiceDisconnected() {}
        })
    }
}