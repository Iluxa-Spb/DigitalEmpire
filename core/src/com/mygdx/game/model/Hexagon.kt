package com.mygdx.game.model

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.*
import com.badlogic.gdx.math.EarClippingTriangulator
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import com.mygdx.game.utils.AppConstants
import java.lang.Math.*

class Hexagon: Actor {
    private var center: Vector2
    private val size: Int = AppConstants.SIZE_FIELD
    val vertices: Array<Float> = Array(12,{0F})
    private var sprite: PolygonSprite

    constructor(center: Vector2){
        this.center = center
        setBounds(center.x-size, center.y-size+size/8, size.toFloat()*2, size.toFloat()*2-size/4)
        sprite = createPolygonSprite(center)
        sprite.setColor(Color.GOLD)
    }
    fun setPolygonSprite(x: Int, y: Int){
        center.set(x.toFloat(),y.toFloat())
        sprite = createPolygonSprite(center)
    }

    private fun createPolygonSprite(center: Vector2): PolygonSprite{
        val texture = Texture(Gdx.files.internal("badlogic.jpg"))
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat)
        val sprite = Sprite(texture)

        val vert: Array<Vector2> = Array(6,{Vector2()})
        for (i in vert.indices){
            vert[i] = flat_hex_corner(center, AppConstants.SIZE_FIELD, i)
        }
        vertices.set(0,vert.get(0).x);vertices.set(1,vert.get(0).y)
        vertices.set(2,vert.get(1).x);vertices.set(3,vert.get(1).y)
        vertices.set(4,vert.get(2).x);vertices.set(5,vert.get(2).y)
        vertices.set(6,vert.get(3).x);vertices.set(7,vert.get(3).y)
        vertices.set(8,vert.get(4).x);vertices.set(9,vert.get(4).y)
        vertices.set(10,vert.get(5).x);vertices.set(11,vert.get(5).y)

        val polygonRegion = PolygonRegion(sprite,vertices.toFloatArray(), EarClippingTriangulator().computeTriangles(vertices.toFloatArray()).toArray())
        return PolygonSprite(polygonRegion)
    }

    fun flat_hex_corner(center:Vector2, size:Int, i:Int): Vector2 {
        val angle_deg = 60 * i
        val angle_rad = PI / 180 * angle_deg
        return Vector2(center.x + size * cos(angle_rad).toFloat(),
                center.y + size * sin(angle_rad).toFloat())
    }

    fun draw(pSB: PolygonSpriteBatch){
        sprite.draw(pSB)
    }

    fun dispose(){

    }
}