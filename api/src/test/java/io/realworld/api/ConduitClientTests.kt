package io.realworld.api

import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ConduitClientTests {

    private val conduitClient=ConduitClient()

    @Test
    fun `GET articles`(){
        runBlocking{
            val articles= conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `GET articles by author`(){
        runBlocking{
            val articles= conduitClient.api.getArticles(author="Gerome")
            assertNotNull(articles.body()?.articles)
        }

    }

    @Test
    fun `GET articles by tags`(){

        runBlocking{
            val articles= conduitClient.api.getArticles(tags= listOf("introduction"))
            assertNotNull(articles.body()?.articles)
        }

    }

}