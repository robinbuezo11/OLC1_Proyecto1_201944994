/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.LinkedList;

/**
 *
 * @author Robin
 */
public class ListErrors extends LinkedList<String[]>{

    public ListErrors() {
    }
    
    public LinkedList<String> getCodeErrors(){
        if(this.size()>0){
            int count = 1;
            String data = """
                        <!DOCTYPE html>
                        <html lang="es">
                        <head>
                        <meta charset="utf-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1">
                        <title>Errores</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
                        </head>
                        <body>
                        <div class="container text-center">
                        <h1>Tabla de Errores</h1>
                        <table class="table table-striped">
                        <thead class="table-dark">
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">Tipo de Error</th>
                        <th scope="col">Descripción</th>
                        <th scope="col">Línea</th>
                        <th scope="col">Columna</th>
                        </tr>
                        </thead>
                        """;
            for(String[] err: this){
                data += "<tr>"
                        +"<td scope=\"col\">"+count+"</th>"
                        +"<td scope=\"col\">"+err[0]+"</th>"
                        +"<td scope=\"col\">El caractér \""+err[1]+"\" no pertenece al lenguaje.</th>"
                        +"<td scope=\"col\">"+err[2]+"</th>"
                        +"<td scope=\"col\">"+err[3]+"</th>"
                        +"</tr>";
                count+=1;
            }


            data += """
                    </table>
                    </div>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
                    </body>
                    </html>""";
            LinkedList<String> result = new LinkedList<>();
            result.add("N");
            result.add(data);
            return result;
        }else{
            LinkedList<String> result = new LinkedList<>();
            result.add("Y");
            return result;
        }
    }
}
