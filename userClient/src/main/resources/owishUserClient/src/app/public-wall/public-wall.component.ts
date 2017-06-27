import { Component, OnInit } from '@angular/core';
import {Http, Response} from "@angular/http";
@Component({
  selector: 'app-public-wall',
  templateUrl: './public-wall.component.html',
  styleUrls: ['./public-wall.component.css']
})
export class PublicWallComponent implements OnInit {
  data: string[];
  constructor(public http: Http) {
    this.http.request("/owish/findAllWishs")
      .subscribe((res: Response) => {
        console.log(res.json());
        this.data = res.json()['hits']['hits'].map(function(i){
          return i['_source'].content;
        });
    });
  }

  ngOnInit() {
  }

}
