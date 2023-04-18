package com.example.fragmentmanual.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fragmentmanual.R
import com.example.fragmentmanual.ui.compatibility.CompatibilityFragment
import com.example.fragmentmanual.ui.compatibility.CompatibilityFragment.Companion.NAME_BUNDLE
import com.example.fragmentmanual.ui.compatibility.CompatibilityFragment.Companion.SURNAME_BUNDLE
import com.google.android.material.bottomnavigation.BottomNavigationView


/*Creación de una navegación de diferentes fragments en una Activity:
1. Implementar la librería de los fragment en el gradle
2. Crear los fragments que queremos incluir (los comentarios están en fragmentList)
3a. Crear en el .xml de la actividad un FragmentContainerView que será el espacio donde encapsularemos
los fragment (IMPORTANTE: poner el name del fragment que queremos contener y otorgar un id a la vista
del Container)
3b. Tendrá mayor potencia cargar el fragment desde el código (para pasar parámetros) con el
supportFragmentManagerdonde habrá que indicarle el nombre del fragment y el del contenedor del activity
4.Crearemos un Bundle con los parámetros que queramos pasar al fragment y enviamos el Bundle
mediante el supportFragment

3c. Crearlo con un bottomNavigationView
4. Para ello crearemos dos vistas en la actividad, un FragmentContainerView donde se cargarán los
diferentes fragments; y un BottomNavigatonView que será la barra que nos permita navegar entre
los fragments. IMPORTANTE: ambos necesitan id para funcionar
5. Para el Navigation nos hará falta un recursos (res): un menu que contenga los fragments en sus
items (definiendo id, icon y title para cada uno)
6. Para el Container nos hará falta otro recurso: un grafo de navegación con los fragments. También
habrá que pasarle el name "androidx.navigation.fragment.NavHostFragment" al .xml para su funcionamiento
7. Una vez creados todos los elementos gráficos, hará falta enlazarlos en la activity. Para ello
definimos dos variables: el bottomNavigationView y el navController (lateinit) que se definirá
mediante el navHostFragment y se enlazarán por medio del setupWithNavController*/

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Con este if nos garantizamos que el fragment solo se cree una vez cuando se pause la actividad
        (en los giros por ejemplo) ya que el savedInstanceState solo será nulo la primera vez*/
        /*if (savedInstanceState == null) {
            val bundle = bundleOf(
                NAME_BUNDLE to "Pablo es el mejor",
                SURNAME_BUNDLE to "Y además Nuwanda Manda"
            )
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<CompatibilityFragment>(R.id.fragment_container, args = bundle)
            }
        }*/

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController((navController))
    }
}