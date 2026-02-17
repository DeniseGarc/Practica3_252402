package mx.edu.itson.practica3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {

    //ArrayList con los productos
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var menuOption: String? = intent.getStringExtra("menuType")

        // instanciar la función agregarProductos()
        agregarProductos(menuOption)

        var listview: ListView = findViewById(R.id.listView) as ListView

        var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

    }

    fun agregarProductos(option: String?){
        when(option){
            "Antojitos" -> {
                menu.add(Product("Quesadillas",R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada - Filled with your choice of meat, served with salad", 6.29))
                menu.add(Product("Huaraches",R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema - Big thick tortilla with beans, your choice of meat, fresh cheese, and sour cream.", 11.49))
                menu.add(Product("Gringas",R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña. Flour tortilla filled with cheese, marinated pork and pineapple.", 8.39))
                menu.add(Product("Sincronizada",R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole. Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.", 7.99))
                menu.add(Product("Tostadas",R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.", 4.59))
                menu.add(Product("Sopes",R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, and sour cream.", 3.99))
                menu.add(Product("Coctel Mixto",R.drawable.coctel, "shrimp, octopus, pico de gallo, avocado, lime and coctel sauce. served cold.", 21.99))
            }
            "Especialidades" -> {
                menu.add(Product("Botana De Camarones a La Diabla",R.drawable.botanacamarones, "We’ll try our best to accommodate requests, but can’t make changes that affect pricing.", 19.99))
                menu.add(Product("Ceviche",R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo, served with chips.", 6.99))
                menu.add(Product("Fajita Quesadilla",R.drawable.fajitaquesadilla, "Quesadilla extra grande (10 inches), rellena con tu carne favorita, cebolla asada, chile morron. Servida con arroz, frijoles, lechuga, crema y pico de gallo. 10 inches quesadilla filled with your choice of meat, cooked with grilled onions, banana peppers and tomatoes. Served with rice, beas, lettuce, sour cream and pico de gallo.", 14.59))
                menu.add(Product("Mojarra Frita - Fried Fish",R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas. Fried tilapia served with lettuce, onions, tomatoes, avocado and tortillas.", 17.99))
                menu.add(Product("1 Piece Taco Traditional",R.drawable.taco, "", 2.99))
            }
            "Sopas" -> {
                menu.add(Product("Sopa De Mariscos",R.drawable.sopamariscos, "Seafood soup", 21.99))
                menu.add(Product("Pozole",R.drawable.pozole, "WEDNSDAY - SUNDAY Pork ribs and bonston butt stew with homminy and oregano. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL.", 7.99))
                menu.add(Product("Caldo De Camarón",R.drawable.caldocamaron, "Shrimp soup.", 13.99))
                menu.add(Product("Caldo De Res",R.drawable.caldores, "Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL", 14.39))
                menu.add(Product("Menudo",R.drawable.menudo, "Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down through generations.", 7.99))
            }
            "Tortas" -> {
                menu.add(Product("Torta Mixta",R.drawable.tortamixta, "Chorizo, asada y pastor. Mexican sausage, steak and marinated por.", 13.99))
                menu.add(Product("Torta Cubana",R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.", 14.49))
                menu.add(Product("Torta Regular",R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", 13.39))
                menu.add(Product("Milanesa De Res Torta",R.drawable.tortamilanesa, "Breaded steak.", 13.99))
                menu.add(Product("Small Mexican Torta",R.drawable.smallmexican, "Bolillo bread sandwich with your of meat, shredded lettuce, avocado, tomato, onion and sour cream.", 11.99))
            }
            "Combinaciones" -> {
                menu.add(Product("Traditional Taco Combo",R.drawable.combinationtaco, "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", 6.99))
                menu.add(Product("Cinco",R.drawable.cinco, "One hard sell taco with your choice of meat, lettuce and cheese. One burrito with your choice of meat, pico de gallo, sour cream, and beans. Served with rice and beans.", 10.99))
                menu.add(Product("Mexican Burritos",R.drawable.cominationburros, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz. Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, and sour cream.", 13.69))
                menu.add(Product("Los Portales Burrito",R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans. Served with a side of lettuce salad, tomatoes, sour cream and guacamole.", 14.59))
                menu.add(Product("Dos Amigos",R.drawable.dosamigos, "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese. Served with a side of rice and beans.", 10.99))
                menu.add(Product("Burrito Pepe",R.drawable.burritopepe, "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo. Served with a side of rice.", 10.99))
            }
            "Drinks" -> {
                menu.add(Product("CAGUAMA MODELO",R.drawable.caguama, "", 9.99))
                menu.add(Product("Soft Drinks 20 oz.",R.drawable.sodas, "Sodas 20 oz.", 2.99))
                menu.add(Product("Jarritos",R.drawable.jarritos, "", 2.75))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = contexto
    }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any? {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }
        }
    }