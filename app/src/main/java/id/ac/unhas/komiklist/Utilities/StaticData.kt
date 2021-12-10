package id.ac.unhas.komiklist.Utilities

import id.ac.unhas.komiklist.komik

class StaticData {

    companion object{
        var volumes: Any = ""
        var image_url: String = ""
        var members: String = ""
        var rank: String = ""
        var score: String = ""
        var start_date: String = ""
        var title: String = ""
        var type: String = ""
        var url: String = ""

        fun fill(komik: komik){
            volumes = komik.volumes.toString()
            image_url = komik.image_url
            members = komik.members.toString()
            rank = komik.rank.toString()
            score = komik.score.toString()
            start_date = komik.start_date
            title = komik.title
            type = komik.type
            url = komik.url
        }
    }
}