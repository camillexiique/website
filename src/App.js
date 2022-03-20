//Pour ajouter un logo
/*import logo from './logo.svg';*/

import './App.css';
import donnees from './donnees';
import  './categories.css';
import Categories from './components/Categories';
import Newcategories from './components/Newcategorie';

function App() {

  const LesDonnees = donnees;

  return (
    <div className="App">
      <header className="App-header">
        
        <p>DELTA-BLOG</p>
       
      </header>

      <main>

      {/*Fiche produit*/}

      {/*Afficher les produit*/}
      
      <div className = "listeDesCatégories">

        {/*Titre*/}
        
        <h2 className = "ListCatégories"> Liste des Catégories</h2>
        
        {/*L'affichage des produits || containeur*/}
        
        <div>

          <Categories donnees={LesDonnees}/>
          
        </div>


        <div>
          <Newcategories />
        </div>
        
      </div>

      </main>
      <footer className="App-footer">
        
        <p>@DELTA-BLOG</p>
       
      </footer>
    </div>
  );
}

export default App;
