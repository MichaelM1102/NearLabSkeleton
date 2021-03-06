package com.michaelm1102.nearlabskeleton.ui.base.adapter

import androidx.annotation.StringDef
import com.michaelm1102.nearlabskeleton.ui.base.adapter.BaseSelectionAdapter.Companion.MULTI
import com.michaelm1102.nearlabskeleton.ui.base.adapter.BaseSelectionAdapter.Companion.SINGLE

@Retention(AnnotationRetention.SOURCE)
@StringDef(SINGLE, MULTI)
annotation class SelectionMode