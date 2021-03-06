(function(ng){
    var mod = ng.module('productModule');
    
    mod.service('productService', ['CrudCreator','productContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.saveQuestion = function(data)
            {
                //Para las preguntas... questions
                return this.api.one("../questions").customPOST(data).then(function() 
                {
                    console.log("Success");
                });
            };
            //Para los comemtarios...
            this.saveComment = function(data)
            {
                return this.api.one("../orders").customPOST(data).then(function() 
                {
                    console.log("Success");
                });
            };
    }]);
})(window.angular);
