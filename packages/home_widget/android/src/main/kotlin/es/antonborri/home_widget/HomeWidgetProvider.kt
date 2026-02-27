package es.antonborri.home_widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.SharedPreferences

abstract class HomeWidgetProvider : AppWidgetProvider() {

  override fun onUpdate(
      context: Context,
      appWidgetManager: AppWidgetManager,
      appWidgetIds: IntArray,
  ) {
    super.onUpdate(context, appWidgetManager, appWidgetIds)
    val widgetData = HomeWidgetPlugin.getData(context)
    onUpdate(context, appWidgetManager, appWidgetIds, widgetData, false)
  }

  // Backward-compatible overload for existing providers overriding the old signature.
  open fun onUpdate(
      context: Context,
      appWidgetManager: AppWidgetManager,
      appWidgetIds: IntArray,
      isLoading: Boolean,
  ) {
    val widgetData = HomeWidgetPlugin.getData(context)
    onUpdate(context, appWidgetManager, appWidgetIds, widgetData, isLoading)
  }

  // New signature used by providers that need direct widget data.
  open fun onUpdate(
      context: Context,
      appWidgetManager: AppWidgetManager,
      appWidgetIds: IntArray,
      widgetData: SharedPreferences,
      isLoading: Boolean,
  ) {
    onUpdate(context, appWidgetManager, appWidgetIds, isLoading)
  }
}
