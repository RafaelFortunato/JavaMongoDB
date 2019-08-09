$.ajax({
    url: 'character',
    type: 'get',
    data: $(this).serialize(),
    success: function (response) {

        response.forEach(function (character, index) {
            console.log(character);

            const x = `<div class="characterCard whiteCard">
                           <div class="characterNameRow">
                               <div class="characterName">${character.name}</div>
                               <div class="characterDate">${character.timeCreated}</div>
                           </div>

                           <div class="characterDetails">
                               <div class="characterDetailsCol">
                                   <div>${character.role}</div>
                                   <div>${character.race}</div>
                               </div>

                               <div class="characterDetailsCol">
                                   <div>Strength ${character.strength}</div>
                                   <div>Wisdom ${character.wisdom}</div>
                               </div>

                               <div class="characterDetailsCol">
                                   <div>Agility ${character.agility}</div>
                                   <div>Vitality ${character.vitality}</div>
                               </div>
                           </div>
                       </div>`;

            $('.characterCardsContainer').append(x);

        });
    },
    error: function (error) {
        alert(error);
    }
})