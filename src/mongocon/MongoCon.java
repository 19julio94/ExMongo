

package mongocon;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;




public class MongoCon {

    public static void main(String[] args) {
        
        MongoCon mc=new MongoCon();
        
        mc.Conexion();
        
       
    }
    
    public void Conexion(){
    
        MongoClient cliente= new MongoClient("localhost",27017);
        
        //acceder a base 
        
        MongoDatabase base= cliente.getDatabase("training");
        
        //acceder a unha coleccion
        
        MongoCollection <Document> coleccion= base.getCollection("scores");
        
        //BasicDBObject consulta = new BasicDBObject("kind","essay");
        /////Para consultar por id's///////
        BasicDBObject consulta = new BasicDBObject("_id",new ObjectId("4c90f2543d937c033f424703"));
        //para seleccionar os campos deseados
        ///////////////////////////////////////////////
        BasicDBObject claves= new BasicDBObject();
        
        claves.put("_id",0);
        claves.put("score",1);
        claves.put("student",1);
        ///////////////////////////////////////////////
        //FindIterable <Document> cursor = coleccion.find(consulta);
        
        /////usamos este obxeto para os campos selecionados//////////
        //FindIterable <Document> cursor = coleccion.find(consulta).projection(claves);
        //MongoCursor<Document> iterator=cursor.iterator();
        //O facer esta consulta o campo kind vai mosalo como null,porque non especificamos que o collese entonces amosara ese nulo//////
       /* while(iterator.hasNext()){
        
        
        Document n= iterator.next();9
        
        String s= n.getString("kind");
        
        Double sc= n.getDouble("score");
        
        Double st= n.getDouble("student");
        
            System.out.println(s + " " + sc + " " + st);
     
        
        }*/
         
        
        /////CONSULTA PARA O ID////
        
        /*Document d=coleccion.find(consulta).projection(claves).first();
        
        System.out.println(d);*/
        
        
        //Actualizacion de un documento por clave
        
        //ObjectId idx = new ObjectId("4c90f2543d937c033f424703");
        //coleccion.updateOne(new Document("_id",idx),new Document("$set",new Document("score",9898)));
        //Para aumentar un documento//
        
        //coleccion.updateOne(new Document("_id",idx),new Document("$inc",new Document("score",-4)));
       //coleccion.deleteOne("_id",idx);
        
        //Engadir un Documento////
        
        Document engadir= new Document("_id",1500)
                .append("kind","taller")
                .append("score", 1111)
                .append("student", 2222)
                .append("enderezo", 
                        
                        new Document()
                        .append("rua", "urzaiz")
                        .append("numero", 7)
                        
                        );
        
        //coleccion.insertOne(engadir);
        coleccion.updateOne(new Document("_id",1500),new Document("$set",new Document("score",4000)));
                
        
        
        cliente.close();
        
        
    
    
    
    }
}
