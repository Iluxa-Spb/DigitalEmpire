package com.mygdx.game.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.model.Hexagon
import com.mygdx.game.ui.TableStage
import com.mygdx.game.utils.AppConstants
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.Stage
import com.mygdx.game.model.HexagonTable


class GameScreen(val viemport: Viewport): ScreenAdapter() {
    val camera = OrthographicCamera(AppConstants.APP_WIDTH,AppConstants.APP_HEIGHT)
    val hex = Hexagon(Vector2(AppConstants.SIZE_FIELD.toFloat(),AppConstants.SIZE_FIELD.toFloat()))
    //val batch = PolygonSpriteBatch()
    //val tableStage = TableStage()

    private val batch = PolygonSpriteBatch()
    private val renderer = ShapeRenderer()

    val stage = Stage(viemport, batch)
    val hexagonTable = HexagonTable()

    override fun show() {
        super.show()
        //tableStage.viewport = viemport
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        stage.addActor(hex)
        stage.isDebugAll = true
        renderer.projectionMatrix = stage.camera.combined

        //tableStage.act(delta)
        //tableStage.draw()

        stage.act()
        stage.draw()

        batch.begin()
        hex.draw(batch)
        batch.end()

        renderer.begin(ShapeRenderer.ShapeType.Line)
        renderer.color = Color.GRAY
        Gdx.gl.glLineWidth(3F)
        renderer.polygon(hex.vertices.toFloatArray())
        renderer.end()
        Gdx.gl.glLineWidth(1F)
    }

    override fun resize(width: Int, height: Int) {
        viemport.update(width,height);
    }

    override fun resume() {
        super.resume()
    }

    override fun pause() {
        super.pause()
    }

    override fun dispose() {
        super.dispose()
    }

}