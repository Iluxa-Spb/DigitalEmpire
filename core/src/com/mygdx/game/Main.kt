package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.mygdx.game.utils.AppConstants
import com.mygdx.game.view.GameScreen
import com.mygdx.game.view.LoadingScreen

class Main : Game() {
    val viewport: FitViewport = FitViewport(AppConstants.APP_WIDTH.toFloat(), AppConstants.APP_HEIGHT.toFloat())

    override fun create() {
        screen = GameScreen(viewport)
    }
}
