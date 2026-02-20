package fr.isen.vojtechsanda.thegreatestcocktailapp.storage

import android.content.SharedPreferences
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

fun SharedPreferences.getStringSetFlow(
    key: String,
    defaultValue: Set<String> = setOf()
): Flow<Set<String>> = callbackFlow {
    val listener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, changedKey ->
        if (changedKey == key) {
            trySend(
                prefs.getStringSet(key, defaultValue) ?: defaultValue
            )
        }
    }

    registerOnSharedPreferenceChangeListener(listener)

    trySend(getStringSet(key, defaultValue) ?: defaultValue)

    awaitClose {
        unregisterOnSharedPreferenceChangeListener(listener)
    }
}
