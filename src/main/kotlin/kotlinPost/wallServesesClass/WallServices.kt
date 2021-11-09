package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Element
import kotlinPost.excaption.PostNotFoundException

abstract class WallServices<E : Element> {

    var elements = mutableListOf<E>()
    var deletedList = mutableListOf<E>()

    fun add(element: E): E {
        elements += element
        return elements.last()
    }

    fun delete(elem: E): E {
        deletedList += elem
        elements.remove(elem)
        return deletedList.last()
    }

    fun getById(id: Int): E {
        return elements.find { it.id == id } ?: throw PostNotFoundException("Comment by id #$id is not found in post!")
    }

    fun get(): List<E> {
        return elements.sortedBy { it.date }
    }

    fun print() {
        println(elements.last()).toString()
    }
}