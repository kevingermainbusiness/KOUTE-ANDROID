package ht.koute.android.utils

import android.content.Context
import android.widget.Toast
import ht.koute.android.R
import ht.koute.android.data.Suggestions

object Util {
    object AppLevelConstants {
        const val FAITH_COLLECTION = "faith_shows"
        const val NEW_SHOW_COLLECTION = "new_shows"
        const val RECOMMENDED_COLLECTION = "recommended_shows"
        const val SERMONS_COLLECTION = "sermons_shows"
        const val MEDIA_ROOT_ID = "root_id"
        const val NOTIFICATION_CHANNEL_ID = "koute_sound"
        const val NOTIFICATION_ID = 1
        const val UPDATE_PLAYER_POSITION_INTERVAL = 100L

        const val NETWORK_ERROR = "NETWORK_ERROR"
    }

    fun createToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun createSuggestionsDataSet(context: Context): ArrayList<Suggestions> {
        val mSuggestionsData = arrayListOf<Suggestions>()
        mSuggestionsData.add(Suggestions(0, context.getString(R.string.faith_category)))
        mSuggestionsData.add(Suggestions(1, context.getString(R.string.obedience_category)))
        mSuggestionsData.add(Suggestions(2, context.getString(R.string.love_category)))
        mSuggestionsData.add(Suggestions(3, context.getString(R.string.sharing_category)))
        mSuggestionsData.add(Suggestions(4, context.getString(R.string.compassion_category)))
        mSuggestionsData.add(Suggestions(5, context.getString(R.string.devotion_category)))
        return mSuggestionsData
    }
}