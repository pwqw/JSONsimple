# Importantes notas de seguridad:
## No lo utilice para leer archivos JSON que no haya creado usted.
### Verifique qué archivo está siendo leido por esta Clase.
Esto se debe a que el método `parse` lee el archivo completo y lo analiza como si fuera código. Lo cual abre camino a inyecciones.
#### De cualquier modo esta información necesita ser verificada..
Utilícese bajo su responsabilidad.


Tested on supercollider 3.8.0

# Installation
``` supercollider
include("https://github.com/AlexisCaffa/JSONsimple")
```  
Then recompile class library.  

# Example
``` supercollider
(
// creo el objeto
a = (
	birra: 12,
	birrb: [ 13, 14, 15 ],
	birrc: "algo",
	birrd: true,
	birre: Array.fill(8)
);

// convert to string json
b = JSON.stringify(a);

// parse from string
c = JSON.parse(b);
)
```  

## Credits
All credits to [crucialfelix](https://github.com/crucialfelix) (see [API](https://github.com/crucialfelix/API)).  
