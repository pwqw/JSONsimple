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
