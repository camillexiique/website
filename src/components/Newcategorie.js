import  './Newcategorie.css';

export default function Newcategories(){

    return(
      //newCategories = new product
        <div className="newCategories">
        <h3 className="title">ADD Categories !</h3>

        <div className="newCategorie_contaire">
            <lable> Categorie: </lable>
            <input className="newCategories_input" type="text" placeholder="new categories" name="name" value=""/>
        </div>
        
       

        <textarea className="newCategorie_descriptoin"
        placeholder="Descption" name="description" value =""/>

        <button className="newCategorie_button"> CONFIRM ADD </button>

        </div>
    )       
    
}