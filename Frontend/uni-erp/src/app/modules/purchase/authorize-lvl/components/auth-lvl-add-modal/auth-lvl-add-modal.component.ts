import { AuthorizeLvlService } from './../../../../../core/services/Purchase/authorize-lvl.service';
import { Component, OnInit } from '@angular/core';
import { AuthorizeLvl } from 'src/app/core/models/Purchase/authorizelvl';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';

@Component({
  selector: 'app-auth-lvl-add-modal',
  templateUrl: './auth-lvl-add-modal.component.html',
  styleUrls: ['./auth-lvl-add-modal.component.less']
})
export class AuthLvlAddModalComponent implements OnInit {


	authLvl: AuthorizeLvl = new AuthorizeLvl();
  constructor(private authLvlService: AuthorizeLvlService, private modalRef: NzModalRef<AuthLvlAddModalComponent>,private message: NzMessageService) { }

  ngOnInit() {
	}

	saveAuthLvl(){
			// console.log(this.authLvl);
			this.authLvlService.saveAuthLvl(this.authLvl).subscribe(
				data => {
					console.log(data['status']+"data");
				},
				error => {
					console.log(error['status']+"error");
					console.log(error);
					this.message.create('success', `Authorize Level Successfully Added!`);
				}
			);
			this.modalRef.close();

	}
	onCancel() {
		this.modalRef.triggerCancel();
	}

}
