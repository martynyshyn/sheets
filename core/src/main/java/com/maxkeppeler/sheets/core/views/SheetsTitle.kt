/*
 *  Copyright (C) 2020. Maximilian Keppeler (https://www.maxkeppeler.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.maxkeppeler.sheets.core.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.maxkeppeler.sheets.core.R
import com.maxkeppeler.sheets.core.utils.colorOfAttrs

/** Custom TextView used for for the title of a sheet. */
class SheetsTitle
@JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    styleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(ctx, attrs, styleAttr) {

    init {

        val a = ctx.obtainStyledAttributes(attrs, R.styleable.SheetsTitle, styleAttr, 0)

        val colorDefault = colorOfAttrs(ctx, R.attr.sheetsPrimaryColor, R.attr.colorPrimary)
        val color = a.getColor( R.styleable.SheetsTitle_sheetsTitleColor, colorDefault)
        setTextColor(color)

        val height = a.getDimensionPixelSize( R.styleable.SheetsTitle_sheetsTitleLineHeight, 0)
        height.takeIf { it != 0 }?.let { lineHeight = height }

        val fontResId = a.getResourceId( R.styleable.SheetsTitle_sheetsTitleFont, 0)
        fontResId.takeIf { it != 0 }?.let { typeface = ResourcesCompat.getFont(ctx, it) }

        val spacing =
            a.getFloat( R.styleable.SheetsTitle_sheetsTitleLetterSpacing, 0f)
        spacing.takeIf { it != 0f }?.let { letterSpacing = it }

        a.recycle()
    }
}
