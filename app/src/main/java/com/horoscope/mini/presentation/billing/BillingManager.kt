package com.horoscope.mini.presentation.billing

import android.content.Context
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingResult
import javax.inject.Inject

class BillingManager @Inject constructor(
    private val context: Context
) {
    private val billingClient = BillingClient.newBuilder(context)
        .setListener { _, _ -> }
        .enablePendingPurchases()
        .build()

    fun startConnection() {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    // подключено
                }
            }

            override fun onBillingServiceDisconnected() {
                // отключено
            }
        })
    }
}