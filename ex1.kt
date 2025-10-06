package tp14_1

import kotlinx.coroutines.*

suspend fun verifierDisponibilite(): Boolean {
    println(" Vérification des ingrédients...")
    delay(2000L)
    println(" Ingrédients disponibles")
    return true
}

suspend fun preparerCommande() {
    println(" Préparation de la commande...")
    delay(5000L)
    println(" Commande prête")
}

suspend fun livrerRepas() {
    println(" Livraison en cours...")
    delay(3000L)
    println(" Repas livré")
}

fun main() = runBlocking {
    println(" Début du traitement de la commande")
    val ingredientsOk = verifierDisponibilite()
    if (!ingredientsOk) {
        println(" Commande annulée : ingrédients manquants")
        return@runBlocking
    }

    preparerCommande()

    withContext(Dispatchers.IO) {
        livrerRepas()
    }

    println(" Commande terminée avec succès")
}
