$("#characterForm").submit(function(e) {
   $.ajax({
       url: 'character',
       type: 'post',
       data:$(this).serialize(),
       success: function() {
           alert('Character created successfully!');
       }, error: function(error) {
           alert(error);
       }
   })
});

