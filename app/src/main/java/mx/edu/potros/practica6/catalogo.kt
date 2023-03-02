package mx.edu.potros.practica6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Peliculas>()
    var gridview: GridView = findViewById(R.id.gridview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        gridview.adapter = adapter
    }

    fun cargarPeliculas() {
        peliculas.add(Peliculas("1917", R.drawable.war, R.drawable.warheader, "British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy."))
        peliculas.add(Peliculas("Big Hero", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called “Big Hero 6.”"))
        peliculas.add(Peliculas("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb’s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))
        peliculas.add(Peliculas("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Peliculas("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency codenamed MiB. This agency is some kind of extraterrestrial surveillance corporation. Then, one of the agency’s finest men only going by the name “K” (Tommy Lee Jones), is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the “Bug” race. He takes the body of a farmer (Vincent D’Onofrio) and heads to New York. He is searching for a super energy source called “The Galaxy”. Now, Agents J and K must stop the bug before it can escape with the galaxy."))
        peliculas.add(Peliculas("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the ‘secret life of toys’ when people are not around. When Buzz Lightyear, a space-ranger, takes Woody’s place as Andy’s favorite toy, Woody doesn’t like the situation and gets into a fight with Buzz. Accidentally Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andy’s room. But while on the outside they get into all kind of trouble while trying to get home."))

        peliculas.add(Peliculas("Dr. House", R.drawable.drhouse, R.drawable.househeader, "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        peliculas.add(Peliculas("Dr. Who", R.drawable.drwho, R.drawable.drwhoheader, "Traveling across time and space, the immortal time-lord known as ‘The Doctor’ travels across the universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-lord adversary The Master to the sinister Davros, creator of The Daleks."))
        peliculas.add(Peliculas("Friends", R.drawable.friends, R.drawable.friendsheader, "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are six 20 something year-olds, living off of one another in the heart of New York City. Over the course of ten years, this average group of buddies goes through massive mayhem, family trouble, past and future romances, fights, laughs, tears and surprises as they learn what it really means to be a friend."))
        peliculas.add(Peliculas("Smallville", R.drawable.smallville, R.drawable.smallvilleheader, "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he’s either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. Clark’s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark’s outlandish valor. However, on the face of it, Clark just seems a normal boy who’s slightly more secretive than usual."))
    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Peliculas>()
        var contexto: Context? = null

        constructor(context: Context, peliculas: ArrayList<Peliculas>): super() {
            this.peliculas = peliculas
            this.contexto = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.peliculas, null)

            var imagen = vista.findViewById(R.id.iv_pelicula) as ImageView
            var nombre = vista.findViewById(R.id.tv_titulo) as TextView

            imagen.setImageResource(pelicula.image)
            nombre.setText(pelicula.titulo)

            vista.setOnClickListener {
                var intent = Intent(contexto, detalle_pelicula::class.java)
                intent.putExtra("nombre", pelicula.titulo)
                intent.putExtra("image", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                contexto!!.startActivity(intent)
            }

            return vista
        }
    }
}