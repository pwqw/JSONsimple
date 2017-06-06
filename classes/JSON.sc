
JSON {

    classvar <tab, <nl;

    *initClass {
        tab = [$\\, $\\, $t].as(String);
        nl = [$\\, $\\, $n].as(String);
    }
    *stringify { arg obj;
        var out;

        if(obj.isString, {
            ^obj.asCompileString.reject(_.isControl).replace("\n", JSON.nl).replace("\t", JSON.tab);
         });
        if(obj.class === Symbol, {
            ^JSON.stringify(obj.asString)
        });

        if(obj.isKindOf(Dictionary), {
            out = List.new;
            obj.keysValuesDo({ arg key, value;
                out.add( key.asString.asCompileString ++ ":" + JSON.stringify(value) );
            });
            ^("{" ++ (out.join(", ")) ++ "}");
        });

        if(obj.isNil, {
            ^"null"
        });
        if(obj === true, {
            ^"true"
        });
        if(obj === false, {
            ^"false"
        });
        if(obj.isNumber, {
            if(obj.isNaN, {
                ^"null"
            });
            if(obj === inf, {
                ^"null"
            });
            if(obj === (-inf), {
                ^"null"
            });
            ^obj.asString
        });
        if(obj.isKindOf(SequenceableCollection), {
            ^"[" ++ obj.collect({ arg sub;
                        JSON.stringify(sub)
                    }).join(", ")
                ++ "]";
        });

        // obj.asDictionary -> key value all of its members

        // datetime
        // "2010-04-20T20:08:21.634121"
        // http://en.wikipedia.org/wiki/ISO_8601

        ("No JSON conversion for object" + obj).warn;
        ^JSON.stringify(obj.asCompileString)
    }

  // better would be
  // http://json-sans-eval.googlecode.com/svn/trunk/src/json_sans_eval.js
  // but that requires better regex

  *parse { arg s;
    ^(s.parseYAML)
  }
}
