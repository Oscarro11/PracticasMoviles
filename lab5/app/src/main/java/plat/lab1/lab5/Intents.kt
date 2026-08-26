package plat.lab1.lab5

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri

fun Context.openPlayStoreDetails(appPackageName: String){
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                "market://details?id=$appPackageName".toUri()
            ).apply { setPackage("com.android.vending") }
        )
    } catch (_: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                "https://play.google.com/store/apps/details?id=$appPackageName".toUri()
            )
        )
    }
}

fun Context.openGoogleMapsLocation(
    query: String
){
    try{
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                "geo:0,0?q=${Uri.encode(query)}".toUri()
            ).setPackage("com.google.android.apps.maps")
        )
    } catch (_: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                ("https://www.google.com/maps/search/?api=1" + "&query=${Uri.encode(query)}").toUri()
            )
        )
    }
}