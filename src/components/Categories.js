//Contient les categories -- affichage en boucle
import '../categories.css';
import LesDonnees from '../donnees';



export default function categories (properties) {

    const productsElements = properties.donnees.map(i => <div className= "items">
        <h3>Catégories : {i.name}</h3>
        <p>Déscription :{i.description}</p>
    </div>);

    return(

            <div className= "TheCatégories">
                   {productsElements}
            </div>
  

    )


}