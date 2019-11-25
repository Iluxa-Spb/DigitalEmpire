package com.mygdx.game.ui

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Container
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup

class TableStage : Stage() {

    init {

        val stageLayout = Table()
        addActor(stageLayout.apply {
            debugAll()
            setFillParent(true)

            defaults().fill()

            //pad(AppConstants.PADDING)
            //defaults().expand().space(AppConstants.PADDING)

            row().let {
                val headerContainer = Container<WidgetGroup>()
                add(headerContainer.apply {
                    //background = TextureRegionDrawable(TextureRegion(Texture("images/status-bar-background.png")))
                }).height(32f).expandX()
            }

            row().let {
                add().expand()
            }

            row().let {
                val footerContainer = Container<WidgetGroup>()

                add(footerContainer.apply {
                //background = TextureRegionDrawable(TextureRegion(Texture("images/status-bar-background.png")))
                fill()
                //actor = CommandPanel()
            }).height(128f).expandX()
            }
        })
    }
}