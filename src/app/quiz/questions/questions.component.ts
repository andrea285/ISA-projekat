import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Upitnik} from "../personal-info/upitnik";

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  @Output() questionsEmitter = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  upitnik: Upitnik = {
    id: 0,
    dobrovoljan: false,
    odbijen: false,
    lekovi: false,
    nahranjen: false,
    tetoviran: false
  }

  onChange() {
    console.log('sadaewddsc');

    console.log(this.upitnik.odbijen);
    console.log(this.upitnik.lekovi);
    console.log(this.upitnik.nahranjen);
    console.log(this.upitnik.tetoviran);
    console.log(this.upitnik.dobrovoljan);

    this.questionsEmitter.emit(this.upitnik);
  }
}
