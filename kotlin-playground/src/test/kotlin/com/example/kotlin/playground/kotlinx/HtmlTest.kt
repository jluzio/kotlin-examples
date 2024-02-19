package com.example.kotlin.playground.kotlinx

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HtmlTest {

  @Test
  fun simpleDiv() {
    val html = buildString {
      appendHTML(prettyPrint = false).div {
        id = "test"
        +"Hello world!"
      }
    }

    assertThat(html)
      .isEqualTo("""
        <div id="test">Hello world!</div>
        """.trimIndent())
  }

  @Test
  fun simpleHtml() {
    val html = buildString {
      appendHTML(prettyPrint = true).html {
        body {
          h1 {
            +"Page title"
          }
          div {
            id = "test"
            +"Hello world!"
          }
        }
      }

    }.trimIndent()

    assertThat(html)
      .isEqualTo("""
        <html>
          <body>
            <h1>Page title</h1>
            <div id="test">Hello world!</div>
          </body>
        </html>
        """.trimIndent())
  }

}